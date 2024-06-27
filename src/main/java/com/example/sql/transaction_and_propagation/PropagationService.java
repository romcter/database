package com.example.sql.transaction_and_propagation;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@AllArgsConstructor
public class PropagationService {

    private final ApplicationContext context;

    /**
     * For NESTED propagation, Spring checks if a transaction exists, and if so,
     * it marks a save point. This means that if our business logic execution throws
     * an exception, then the transaction rollbacks to this save point. If there’s
     * no active transaction, it works like REQUIRED.
     **/

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("==================== START ===================");
        PropagationService buidingRepository = context.getBean(PropagationService.class);

        buidingRepository.transactionMethodWithRequiredPropagation();
        buidingRepository.transactionMethodWithSupportPropagation();
        buidingRepository.transactionMethodWithNeverPropagation();
        buidingRepository.transactionMethodWithNotSupportedPropagation();

        try {
            buidingRepository.transactionMethodWithMandatoryPropagation();
        } catch (IllegalTransactionStateException ex) {
            System.out.println("Transaction method with MANDATORY propagation throw error when was called from non transactional method with message: " + ex.getMessage());
        }

        buidingRepository.caller();

        System.out.println("==================== FINISH ===================");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void transactionMethodWithRequiredPropagation() {
        System.out.println("Transaction method with REQUIRED propagation: " + TransactionSynchronizationManager.isActualTransactionActive());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void transactionMethodWithSupportPropagation() {
        System.out.println("Transaction method with SUPPORTS propagation: " + TransactionSynchronizationManager.isActualTransactionActive());
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void transactionMethodWithSupportPropagationWhenCalledFromTransactionalMethod() {
        System.out.println("Transaction method with SUPPORTS propagation when called from transactional method: " + TransactionSynchronizationManager.isActualTransactionActive());
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void transactionMethodWithMandatoryPropagation() {
        System.out.println("Transaction method with MANDATORY propagation when called from transactional method: " + TransactionSynchronizationManager.isActualTransactionActive());
    }

    @Transactional(propagation = Propagation.NEVER)
    public void transactionMethodWithNeverPropagation() {
        System.out.println("Transaction method with NEVER propagation when called from non-transactional method: " + TransactionSynchronizationManager.isActualTransactionActive());
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void transactionMethodWithNotSupportedPropagation() {
        System.out.println("Transaction method with NOT_SUPPORTED propagation when called from transactional method: " + TransactionSynchronizationManager.isActualTransactionActive());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void caller() {
        transactionMethodWithSupportPropagationWhenCalledFromTransactionalMethod();
        transactionMethodWithMandatoryPropagation();
        transactionMethodWithNotSupportedPropagation();
        try {
            transactionMethodWithNeverPropagation();
        } catch (IllegalTransactionStateException ex) {
            System.out.println("Transaction method with NEVER propagation throw error when was called from non transactional method with message: " + ex.getMessage());
        }
    }
}
