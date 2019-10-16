from enum import Enum

from python.src.util.stack import Stack


class Token:

    class Type(Enum):
        NUMBER = 1
        OPERATOR = 2

    def __init__(self, value):
        if value == '+' or value == '-':
            self.type = self.Type.OPERATOR
            self.operator = value[0]
            self.precedence = 1
        elif value == '*' or value == '/':
            self.type = self.Type.OPERATOR
            self.operator = value[0]
            self.precedence = 2
        elif value == '^':
            self.type = self.Type.OPERATOR
            self.operator = value[0]
            self.precedence = 3
        else:
            self.type = self.Type.NUMBER
            try:
                self.value = float(value)
            except ValueError:
                raise ValueError("Malformed double: %s" % value)

    def operate(self, a, b):
        result = 0

        if self.operator == '+':
            result = a + b
        elif self.operator == '-':
            result = a - b
        elif self.operator == '*':
            result = a * b
        elif self.operator == '/':
            result = a / b
        elif self.operator == '^':
            result = a**b

        return Token(result)


class Calculator:

    @staticmethod
    def evaluate(expression):
        values = Stack()
        operators = Stack()

        elements = expression.split()
        for element in elements:
            token = Token(element)

            # TODO: your code goes here

        return 0
