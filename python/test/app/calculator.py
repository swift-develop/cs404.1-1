import unittest

from python.src.app.calculator import Calculator


class CalculatorTest(unittest.TestCase):

    def test_single_value(self):
        self.assertAlmostEqual(1, Calculator.evaluate('1'))

    def test_simple_arithmetic(self):
        self.assertAlmostEqual(2, Calculator.evaluate('1 + 1'))
        self.assertAlmostEqual(-1, Calculator.evaluate('3 - 4'))
        self.assertAlmostEqual(12, Calculator.evaluate('3 * 4'))
        self.assertAlmostEqual(3.75, Calculator.evaluate('15 / 4'))

    def test_multiplication_division_precedence(self):
        self.assertAlmostEqual(14, Calculator.evaluate('2 + 3 * 4'))
        self.assertAlmostEqual(2.66, Calculator.evaluate('2 / 3 * 4'), 1)

    def test_exponent_precedence(self):
        self.assertAlmostEqual(32, Calculator.evaluate('2 ^ 3 * 4'))
        self.assertAlmostEqual(-5, Calculator.evaluate('3 - 2 ^ 3'))

    def test_missing_operand(self):
        with self.assertRaises(Exception):
            Calculator.evaluate('1 + 2 - ')

    def test_missing_operator(self):
        with self.assertRaises(Exception):
            Calculator.evaluate('1 2')

    def test_parenthesis(self):
        self.assertAlmostEqual(-4, Calculator.evaluate('( 2 - 3 ) * 4'))
        self.assertAlmostEqual(-4, Calculator.evaluate('( ( 2 - 3 ) ) * 4'))
        self.assertAlmostEqual(4, Calculator.evaluate('2 * ( 3 - 1 )'))

    def test_mismatched_parenthesis_left(self):
        with self.assertRaises(Exception):
            Calculator.evaluate('( ( 3 - 2 ) * 4')

    def test_mismatched_parenthesis_right(self):
        with self.assertRaises(Exception):
            Calculator.evaluate('( 3 - 2 ) * 4 )')


if __name__ == '__main__':
    unittest.main()
