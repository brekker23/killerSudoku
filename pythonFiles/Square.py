
class Square:
    def __init__(self, x, y, value, regionSum):
        self.x = x
        self.y = y
        self.value = value
        self.regionSum = regionSum
        self.connectedNodes = []

    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.value = -1
        self.regionSum = -1
        self.connectedNodes = []
    
    def addConnection(self,node):
        temp1=node.connectedNodes[:]
        temp2=self.connectedNodes[:]
        temp1.append(self)
        temp2.append(node)
        temp3=list(set(temp1+temp2))
        for node in temp3:
            for n in temp3:
                if n is not node and n not in node.connectedNodes:
                    node.connectedNodes.append(n)
        self.setSum(self.regionSum)

    def setSum(self,sumn):
        self.regionSum=sumn
        self.hasSum=True
        for node in self.connectedNodes:
            node.regionSum=sumn
            node.hasSum=True

    def setValue(self,value):
        self.value=value
        if value>=1:
            self.hasValue=True

    def print(self):
        print(f'x={self.x},y={self.y},value={self.value},connectedNodes={self.connectedNodes},sum={self.regionSum}')

