import unittest

from python.src.util.queue import Queue


class QueueTest(unittest.TestCase):

    def setUp(self):
        self.queue = Queue()

    def test_enqueue_peek(self):
        self.queue.enqueue(0)
        self.assertEqual(0, self.queue.peek())

        self.queue.enqueue(1)
        self.assertEqual(0, self.queue.peek())

        self.queue.dequeue()
        self.assertEqual(1, self.queue.peek())

    def test_dequeue(self):
        self.queue.enqueue(0)
        self.queue.enqueue(1)
        self.queue.enqueue(2)

        self.assertEqual(3, self.queue.size())
        self.assertEqual(0, self.queue.dequeue())
        self.assertEqual(1, self.queue.dequeue())
        self.assertEqual(2, self.queue.dequeue())

    def test_is_empty(self):
        self.assertTrue(self.queue.is_empty())
        self.queue.enqueue(0)
        self.assertFalse(self.queue.is_empty())
        self.queue.dequeue()
        self.assertTrue(self.queue.is_empty())

    def test_size(self):
        self.assertEqual(0, self.queue.size())
        self.queue.enqueue(0)
        self.assertEqual(1, self.queue.size())
        self.queue.dequeue()
        self.assertEqual(0, self.queue.size())

    def test_iterator(self):
        size = 5
        for i in range(size):
            self.queue.enqueue(i)

        self.assertEqual(list(range(size)), list(iter(self.queue)))


if __name__ == '__main__':
    unittest.main()
