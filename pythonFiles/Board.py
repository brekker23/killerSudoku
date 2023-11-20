from Square import Square

class Board:
    def __init__(self):
        self.squares = []
        self.buildBoard()

    def buildBoard(self):
        for y in range(9):
            for x in range(9):
                self.squares.append(Square(x,y))
            
    def loadBoard(self, file):
        squares=[]
        with open(file,"r") as f:
            mystr=f.read()
            squares=mystr.split(";")
            i=0
            for square in squares[:-1]:
                vals=square[1:-1].split(":")
                self.squares[i].setValue(int(vals[0]))
                n=vals[2][1:-1].split(".")
                for j in range(len(n)):
                    mainSquare=self.squares[i]
                    if n[j]!='':
                        n[j]=n[j][1:-1]
                        m=n[j].split(",")
                        connectedSquare=self.squares[int(m[0])+9*int(m[1])]
                        mainSquare.addConnection(connectedSquare)
                        if int(vals[1]) != -1:
                            connectedSquare.setSum(int(vals[1]))
                if len(n)==1:
                    self.squares[i].setSum(int(vals[1]))
                i+=1

    def printBoard(self):
        groupCount=0
        valueArray=[]
        for i in range(9):
            for j in range(9):
                valueArray.append('0')
        completedSquares=[]
        for square in self.squares:
            if square not in completedSquares:
                for s in square.connectedNodes:
                    completedSquares.append(s)
                    val=0
                    if s.value>0:
                        val=s.value
                    valueArray[s.y*9+s.x]=f"\033[38;5;{groupCount*40}m{val}\033[0m "
                val=0
                if square.value>0:
                    val=square.value
                valueArray[square.y*9+square.x]=f"\033[38;5;{(groupCount*40)%256}m{val}\033[0m "
            groupCount+=1
        for y in range(9):
            for x in range(9):
                print(valueArray[x+y*9], end="")
            print()


    def printBoardSums(self):
        for y in range(9):
            for x in range(9):
                nsum = self.squares[9*y+x].regionSum
                if nsum >= 10:
                    print(f"{nsum} ", end="")
                else:
                    print(f"{nsum}  ",end="")
            print()    