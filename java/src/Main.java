public class Main {
    public static void main(String[] args) {
        Tree root = new Tree(5);
        
        // Nhánh trái của 5
        root.l = new Tree(3);
        root.l.l = new Tree(20);
        root.l.l.l = new Tree(6);
        
        // Nhánh phải của 5
        root.r = new Tree(10);
        root.r.l = new Tree(1);
        root.r.r = new Tree(15);
        
        // Nhánh của 15
        root.r.r.l = new Tree(30);
        root.r.r.l.r = new Tree(9); // Đây là chỗ tạo ra zigzag: R -> L -> R
        root.r.r.r = new Tree(8);


        Solution solution = new Solution();

        System.out.println(solution.solution(root));
    }
}