public class ll {
    Node head;
    private int size;

    ll() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
        
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }

    public void printList() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null) {
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public void deleteFirst() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        size--;

        head = head.next;
    }
    public void deleteLast() {
        if(head == null) {
            System.out.println("list is empty");
            return;
        }
        size--;
        if(head.next == null) {
            head = null;
            return;
        }

        Node secondlast = head;
        Node last = head.next;
        while(last.next != null) {
            secondlast = secondlast.next;
            last = last.next;
        }

        secondlast.next = null;
    }
    public int getSize() {
        return size;
    }
    public void reverseIterate() {
        if(head == null || head.next == null) {
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            //update
            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node reverseRecursive(Node head) {
        if(head == null || head.next == null) {
            return head; 
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public Node removeNth(Node head, int n) {
        if(head.next == null) {
            return null;
        }
        int size=0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        if(n == size) {
            return head.next;
        }
        int index = size-n;
        int i = 1;
        Node prev = head;
        while (i<index) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return head;
    }
    public Node findMiddle(Node head) {
        Node hare = head;
        Node turtle = head;
        while(hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public boolean isPalindrome(Node head) {
        if(head == null || head.next == null) {
            return true;
        }

        Node middle = findMiddle(head);
        Node secondHead = reverseRecursive(middle.next);
        Node firstHead = head;

        while (secondHead != null) {
            if(firstHead.data != secondHead.data) {
                return false;
            }
            firstHead = firstHead.next;
            secondHead = secondHead.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ll list = new ll();
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        list.addLast("4");
        list.addLast("5");
        list.addLast("6");
        list.printList();
        list.head = list.reverseRecursive(list.head);
        list.printList();
        list.removeNth(list.head, 2);
        list.printList();
        System.out.println(list.isPalindrome(list.head));

        ll l = new ll();
        l.addFirst("1");
        l.addLast("2");
        l.addLast("1");
        System.out.println(l.isPalindrome(l.head));
    }
}