You are given three tables: Students, Friends and Packages. Students contains two columns: ID and Name. Friends contains two columns: ID and Friend_ID (ID of the ONLY best friend). Packages contains two columns: ID and Salary (offered salary in $ thousands per month).

![img.png](img.png)

Write a query to output the names of those students whose best friends got offered a higher salary than them. Names must be ordered by the salary amount offered to the best friends. It is guaranteed that no two students got same salary offer.

### Sample Input

![img_1.png](img_1.png)

### Sample Output

```
Samantha
Julia
Scarlet
```

### Explanation

See the following table:

![img_2.png](img_2.png)

Now,

Samantha's best friend got offered a higher salary than her at 11.55
Julia's best friend got offered a higher salary than her at 12.12
Scarlet's best friend got offered a higher salary than her at 15.2
Ashley's best friend did NOT get offered a higher salary than her
The name output, when ordered by the salary offered to their friends, will be:

Samantha
Julia
Scarlet

# Solution 

```
select s.name from students s
join Packages p1 on s.id = p1.id
join Friends f on s.id = f.id
join Packages p2 on p2.id = f.friend_id
where p1.salary < p2.salary
order by p2.salary;
```

![Screenshot 2023-04-06 at 17.41.13.png](Screenshot%202023-04-06%20at%2017.41.13.png)