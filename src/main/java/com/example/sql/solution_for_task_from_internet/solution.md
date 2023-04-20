# Count Functional Submission

![Screenshot 2023-03-25 at 14.50.00.png](Screenshot%202023-03-25%20at%2014.50.00.png)

## Solution

```
SELECT count(*) 
FROM CITY
WHERE population > 100000;
```

##

# The Sum Function

![Screenshot 2023-03-25 at 15.10.05.png](Screenshot%202023-03-25%20at%2015.10.05.png)

## Solution

```
SELECT sum(population) 
FROM CITY 
WHERE district = 'California';
```

##

# Averages

![Screenshot 2023-03-25 at 15.14.59.png](Screenshot%202023-03-25%20at%2015.14.59.png)

## Solution

```
SELECT avg(population) 
FROM CITY 
WHERE district = 'California';
```

##

# Averages with ROUND down

![Screenshot 2023-03-25 at 15.22.13.png](Screenshot%202023-03-25%20at%2015.22.13.png)

## Solution

```
SELECT ROUND(AVG(population), -1) 
FROM CITY;
```

##

# The sum of all values

![Screenshot 2023-03-25 at 19.04.52.png](Screenshot%202023-03-25%20at%2019.04.52.png)

## Solution

```
SELECT sum(population) 
FROM CITY 
WHERE countrycode = 'JPN';
```

##

# Japan population

![Screenshot 2023-03-25 at 19.18.02.png](Screenshot%202023-03-25%20at%2019.18.02.png)

## Solution

```
SELECT round(sum(lat_n),2), round(sum(long_w),2) FROM station;
```

##

# Query the sum

![Screenshot 2023-03-25 at 19.26.39.png](Screenshot%202023-03-25%20at%2019.26.39.png)

## Solution

```
SELECT round(sum(lat_n),4) FROM station
WHERE lat_n > 38.788 AND lat_n < 137.2345;
```

##

# Sum of the Asia populations

![Screenshot 2023-03-25 at 19.44.23.png](Screenshot%202023-03-25%20at%2019.44.23.png)

## Solution

```
SELECT sum(city.population) FROM city city
INNER JOIN country country ON city.countrycode = country.code
WHERE country.continent = 'Asia';
```

##

# Names of all cities in the Africa continent

![Screenshot 2023-04-05 at 11.36.40.png](Screenshot%202023-04-05%20at%2011.36.40.png)

## Solution

```
SELECT city.name FROM city city
INNER JOIN country country ON city.countrycode = country.code
WHERE country.continent = 'Africa';
```
#


![Screenshot 2023-04-05 at 11.55.43.png](Screenshot%202023-04-05%20at%2011.55.43.png)

## Solution

```
SELECT country.continent, FLOOR(AVG(city.population)) FROM city city
INNER JOIN country country ON city.countrycode = country.code
GROUP BY country.continent;
```

#
![Screenshot 2023-04-18 at 21.56.31.png](Screenshot%202023-04-18%20at%2021.56.31.png)

![Screenshot 2023-04-18 at 21.59.53.png](Screenshot%202023-04-18%20at%2021.59.53.png)

![Screenshot 2023-04-18 at 22.01.20.png](Screenshot%202023-04-18%20at%2022.01.20.png)

![Screenshot 2023-04-18 at 22.02.15.png](Screenshot%202023-04-18%20at%2022.02.15.png)

![Screenshot 2023-04-18 at 22.03.01.png](Screenshot%202023-04-18%20at%2022.03.01.png)

![Screenshot 2023-04-18 at 22.07.54.png](Screenshot%202023-04-18%20at%2022.07.54.png)

![Screenshot 2023-04-20 at 16.38.13.png](Screenshot%202023-04-20%20at%2016.38.13.png)


