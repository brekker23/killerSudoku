from Square import Square
from Board import Board


def solve(board):
    #your code here
    pass

def testSolve(board):
    #DO NOT CHANGE THIS CODE
    for square in board.squares:
        testSum = square.value
        nsum = square.regionSum
        for s in square.connectedNodes:
            testSum+=s.value
        if testSum != nsum:
            return False
        if square.value < 1:
            return False
    testCollumns = [[-1 for i in range(9)] for i in range(9)]
    testRows = [[-1 for i in range(9)] for i in range(9)]
    houses = [[-1 for i in range(9)] for i in range(9)]
    for y in range(9):
        for x in range(9):
            testCollumns[y][x]=board.squares[x + y*9].value
            testRows[x][y]=board.squares[x + y*9].value
            houses[int(x/3) + int(y/3)*3][x%3 + 3*y%3]=board.squares[x + y*9].value
    for collumn in testCollumns:
        i = 0
        while i < len(collumn):
            j = i+1
            while j < len(collumn):
                if collumn[i] == collumn[j]:
                    return False
                j+=1
            i+=1
    for row in testRows:
        i = 0
        while i < len(row):
            j = i+1
            while j < len(row):
                if row[i] == row[j]:
                    return False
                j+=1
            i+=1
    for house in houses:
        i = 0
        while i < len(house):
            j = i+1
            while j < len(house):
                if house[i] == house[j]:
                    return False
                j+=1
            i+=1
    return True