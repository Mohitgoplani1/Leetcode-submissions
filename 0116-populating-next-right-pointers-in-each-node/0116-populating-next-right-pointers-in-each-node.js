var connect = function(root) {
    if (!root) return null;

    let levelStart = root;
    while (levelStart.left) {
        let current = levelStart;
        while (current) {
            current.left.next = current.right;
            if (current.next) {
                current.right.next = current.next.left;
            }
            current = current.next;
        }
        levelStart = levelStart.left;
    }

    return root;
};