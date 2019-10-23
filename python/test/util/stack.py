import unittest

from python.src.util.stack import Stack


class StackTest(unittest.TestCase):

    def setUp(self):
        self.stack = Stack()

    def test_push_peek(self):
        self.stack.push(0)
        self.assertEqual(0, self.stack.peek())

        self.stack.push(1)
        self.assertEqual(1, self.stack.peek())

        self.stack.push(2)
        self.assertEqual(2, self.stack.peek())

    def test_pop(self):
        self.stack.push(0)
        self.stack.push(1)
        self.stack.push(2)

        self.assertEqual(3, self.stack.size())
        self.assertEqual(2, self.stack.pop())
        self.assertEqual(1, self.stack.pop())
        self.assertEqual(0, self.stack.pop())

    def test_is_empty(self):
        self.assertTrue(self.stack.is_empty())
        self.stack.push(0)
        self.assertFalse(self.stack.is_empty())
        self.stack.pop()
        self.assertTrue(self.stack.is_empty())

    def test_size(self):
        self.assertEqual(0, self.stack.size())
        self.stack.push(0)
        self.assertEqual(1, self.stack.size())
        self.stack.pop()
        self.assertEqual(0, self.stack.size())

    def test_iterator(self):
        size = 5
        for i in range(size):
            self.stack.push(i)

        self.assertEqual(list(reversed(range(size))), list(iter(self.stack)))


if __name__ == '__main__':
    unittest.main()
