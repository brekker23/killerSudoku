from Board import Board
from Square import Square
from Solver import solve,testSolve

board = Board()

board.loadBoard("test1.ksdk")

solve(board)

board.printBoard()