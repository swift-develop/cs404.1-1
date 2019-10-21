import unittest

from python.src.util.linkedlist import LinkedList


class LinkedListTest(unittest.TestCase):

    def setUp(self):
        self.list = LinkedList()

    def test_is_empty(self):
        self.assertTrue(self.list.is_empty())
        self.list.insert_front(0)
        self.assertFalse(self.list.is_empty())

    def test_empty_list(self):
        self.assertEqual(0, self.list.size())

        self.assertIsNone(self.list.front())
        self.assertIsNone(self.list.back())

        self.assertIsNone(self.list.remove_front())
        self.assertIsNone(self.list.remove_end())

    def test_insert_front(self):
        self.list.insert_front(0)
        self.list.insert_front(1)

        self.assertEqual(2, self.list.size())

        self.assertEqual(1, self.list.front())
        self.assertEqual(0, self.list.back())

        self.list.insert_front(2)
        self.assertEqual(3, self.list.size())

        self.assertEqual(2, self.list.front())
        self.assertEqual(0, self.list.back())

    def test_insert_end(self):
        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertEqual(2, self.list.size())

        self.assertEqual(0, self.list.front())
        self.assertEqual(1, self.list.back())

        self.list.insert_end(2)
        self.assertEqual(3, self.list.size())

        self.assertEqual(0, self.list.front())
        self.assertEqual(2, self.list.back())

    def test_remove_front(self):
        self.assertIsNone(self.list.remove_front())

        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertEqual(0, self.list.remove_front())
        self.assertEqual(1, self.list.size())
        self.assertEqual(1, self.list.front())

        self.assertEqual(1, self.list.remove_front())
        self.assertEqual(0, self.list.size())
        self.assertIsNone(self.list.front())

    def test_remove_end(self):
        self.assertIsNone(self.list.remove_end())

        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertEqual(1, self.list.remove_end())
        self.assertEqual(1, self.list.size())
        self.assertEqual(0, self.list.front())

        self.assertEqual(0, self.list.remove_end())
        self.assertEqual(0, self.list.size())
        self.assertIsNone(self.list.front())

    def test_remove_not_found(self):
        self.list.insert_end(0)

        self.assertFalse(self.list.remove(1))
        self.assertEqual(1, self.list.size())

        self.assertEqual(0, self.list.front())
        self.assertEqual(0, self.list.back())

    def test_remove_only_element(self):
        self.list.insert_end(0)

        self.assertTrue(self.list.remove(0))
        self.assertEqual(0, self.list.size())

        self.assertIsNone(self.list.front())
        self.assertIsNone(self.list.back())

    def test_remove_first_element(self):
        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertTrue(self.list.remove(0))
        self.assertEqual(1, self.list.size())

        self.assertEqual(1, self.list.front())
        self.assertEqual(1, self.list.back())

    def test_remove_last_element(self):
        self.list.insert_end(0)
        self.list.insert_end(1)

        self.assertTrue(self.list.remove(1))
        self.assertEqual(1, self.list.size())

        self.assertEqual(0, self.list.front())
        self.assertEqual(0, self.list.back())

    def test_remove_middle_element(self):
        self.list.insert_end(0)
        self.list.insert_end(1)
        self.list.insert_end(2)

        self.assertTrue(self.list.remove(1))
        self.assertEqual(2, self.list.size())

        self.assertEqual(0, self.list.front())
        self.assertEqual(2, self.list.back())

    def test_contains(self):
        size = 10

        self.assertEqual(0, self.list.size())
        for i in range(size):
            self.list.insert_end(i)
        self.assertEqual(size, self.list.size())

        self.assertFalse(self.list.contains(size + 1))
        for i in range(size):
            self.assertTrue(self.list.contains(i))


if __name__ == '__main__':
    unittest.main()
