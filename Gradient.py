import numpy as np
import matplotlib.pyplot as pt
import pandas as pd


def gradient_descent():
    #reading data from csv file using pandas pd
    data = pd.read_csv('Data Set.csv')
    x = data['X']
    y = data['Y']
    #print("x{},y{}".format(x,y))
    #assigning initial values of theta0 and theta1
    theta1 = theta0 = 0
    total_data = len(x)
    learning_rate = 0.001
    no_of_iterations = 1000
    prev_cost = -10

    for i in range(no_of_iterations):
        actual_y = theta1 * x
        cost_value = (1/2*total_data)*sum(val**2 for val in (y - actual_y))
        derivative_term = -(1/total_data) * sum(x * (y - actual_y))
        theta1 = theta1 - learning_rate * derivative_term
        print('theta1 value : ', theta1, '    Corresponding cost value : ', cost_value, '   iteration number : ', i)
        pt.scatter(theta1, cost_value)

        if(cost_value == prev_cost):
            print('\n\nLowest cost value : ', cost_value, 'corresponding theta1 value : ', theta1, '\n')
            break
        else:
            prev_cost = cost_value

  #  pt.xlabel('Value of theta1')
   # pt.ylabel('value of cost/error')
   # pt.show()


gradient_descent()