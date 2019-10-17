import unittest

from python.src.util.splaylist import SplayList


class SplayListTest(unittest.TestCase):

    def setUp(self):
        self.list = SplayList()

    def test_back_no_move(self):
        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertEqual(1, self.list.back())
        self.assertEqual(0, self.list.front())

    def test_size_no_move(self):
        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertEqual(2, self.list.size())

        self.assertEqual(0, self.list.front())
        self.assertEqual(1, self.list.back())

    def test_is_empty_no_move(self):
        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertFalse(self.list.is_empty())

        self.assertEqual(0, self.list.front())
        self.assertEqual(1, self.list.back())

    def test_contains(self):
        size = 10

        self.assertEqual(0, self.list.size())
        for i in range(size):
            self.list.insert_end(i)
        self.assertEqual(size, self.list.size())

        self.assertFalse(self.list.contains(size + 1))
        for i in range(size):
            self.assertTrue(self.list.contains(i))

    def test_contains_move_to_front_single_node(self):
        self.list.insert_end(0)

        self.assertTrue(self.list.contains(0))
        self.assertEqual(0, self.list.front())
        self.assertEqual(0, self.list.back())

    def test_contains_move_to_front_first_node(self):
        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertTrue(self.list.contains(0))
        self.assertEqual(0, self.list.front())
        self.assertEqual(1, self.list.back())

        self.assertTrue(self.list.contains(0))
        self.assertTrue(self.list.contains(1))

    def test_contains_move_to_front_last_node(self):
        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertTrue(self.list.contains(1))
        self.assertEqual(1, self.list.front())
        self.assertEqual(0, self.list.back())

        self.assertTrue(self.list.contains(0))
        self.assertTrue(self.list.contains(1))

    def test_contains_move_to_front_middle_node(self):
        self.list.insert_end(0)
        self.list.insert_end(1)
        self.list.insert_end(2)

        self.assertTrue(self.list.contains(1))
        self.assertEqual(1, self.list.front())
        self.assertEqual(2, self.list.back())

        self.assertTrue(self.list.contains(0))
        self.assertTrue(self.list.contains(1))
        self.assertTrue(self.list.contains(2))


if __name__ == '__main__':
    unittest.main()
