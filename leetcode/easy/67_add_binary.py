class Solution:
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        inta = int(a, 2)
        intb = int(b, 2)
        
        intc = format(inta + intb, "b")
        return str(intc)
