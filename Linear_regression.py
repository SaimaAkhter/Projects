import numpy as np
import matplotlib.pyplot as pt
import pandas as pd



def function():
    #reading csv file which contains value of x and y
    data = pd.read_csv('data.csv')
    #print(data.shape)
    #print(data)

    #print('\n')

    #assigning value of X and Y to array x and y
    x = data['X']
    y = data['Y']
    #print(x)
    #print(y)

    #print('\n')

    #assigning 0 to theta0 value
    theta0 = 0

    #reading values of theta1
    reading_theta1 = pd.read_csv('theta1.csv')
    theta1_values = reading_theta1['theta1']
    #print(theta1_values)


    #finding total number of values
    total_theta1_values = len(theta1_values)
    total_x_values = len(x)
    #print(total_theta1_values, '  ', total_x_values)


    #creating new file for storing theta1 values along with cost
    file = open('theta1+cost.csv', 'w')
    file.write('theta1,error(cost)\n')

    #declaring variables for comparison to find minimum cost value
    prev_cost = 9999999999;
    min_theta1 = 0

    #loop for considering all the theta1 values one by one
    for i in range(total_theta1_values):
        j =0
        cost = 0

        for j in range(total_x_values):
            predicted_value = theta0 + theta1_values[i] * x[j]
            cost += (predicted_value - y[j])**2

        cost = cost/(2*total_x_values)

        file.write(str(theta1_values[i]))
        file.write(',')
        file.write(str(cost))
        file.write('\n')

        if(prev_cost>cost):
            prev_cost = cost
            min_theta1 = theta1_values[i]

    file.close()

    print('minimum_cost : ', prev_cost, '   Corresponding theta1 value: ', min_theta1)

    #plotting theta1 value in the x-axis and Jtheta values in y-axis
    new = pd.read_csv('theta1+cost.csv')
    x1 = new['theta1']
    y1 = new['error(cost)']

    #for i in range(len(x1)):
        #print(x1[i], '    ', y1[i])

    pt.scatter(x1,y1, label='scatter plot')
    pt.xlabel('value of theta1')
    pt.ylabel('value of Jtheta')
    pt.legend()
    pt.show()



function()