# Task
#
# You found two items in a treasure chest! The first item weighs weight1 and is worth value1,
#and the second item weighs weight2 and is worth value2.
#What is the total maximum value of the items you can take with you,
#assuming that your max weight capacity is maxW/max_w and you can't come back for the items later?
#
# Example
#
# For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4 and maxW = 8, the output should be
#
# knapsackLight(value1, weight1, value2, weight2, maxW) === 10 (or equivalent for PHP)
#
# You can only carry the first item.
#
# For value1 = 10, weight1 = 5, value2 = 6, weight2 = 4 and maxW = 9, the output should be
#
# knapsackLight(value1, weight1, value2, weight2, maxW) === 16 (or equivalent for PHP)
#
# You're strong enough to take both of the items with you.
#
# For value1 = 10, weight1 = 10, value2 = 6, weight2 = 10 and maxW = 9, the output should be
#
# knapsackLight(value1, weight1, value2, weight2, maxW) === 0 (or equivalent for PHP)
#
# Unfortunately, you're not strong enough to take any one :(

def knapsack_light(value1,weight1,value2,weight2,max_w):
    print(value1,weight1,value2,weight2,max_w)
    #coding and coding..
    if(max_w < min(weight1,weight2)):
        return 0
    elif(weight1 + weight2 <= max_w):
        return value1 + value2
    elif(weight1 <= max_w and weight2 > max_w):
        return value1
    elif(weight2 <= max_w and weight1 > max_w):
        return value2
    else:
        return max(value1, value2)


#Test cases
test.assert_equals(knapsack_light(10,5,6,4,8) , 10)
test.assert_equals(knapsack_light(10,5,6,4,9) , 16)
test.assert_equals(knapsack_light(10,2,11,3,1) , 0)
test.assert_equals(knapsack_light(15,2,20,3,2) , 15)
test.assert_equals(knapsack_light(2,5,3,4,5) , 3)
test.assert_equals(knapsack_light(4,3,3,4,4) , 4)
test.assert_equals(knapsack_light(3,5,3,8,10) , 3)
