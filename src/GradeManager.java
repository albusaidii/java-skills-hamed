public class GradeManager {

    public static String[] reverseStudentNames(String[] names) {
        String[] reversed = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            reversed[i] = new StringBuilder(names[i]).reverse().toString();
        }
        return reversed;
    }

    public static char getLetterGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }

    public static String[] findFailingStudents(String[] names, int[] scores) {
        String result = "";
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                result += names[i] + ",";
            }
        }
        return result.isEmpty() ? new String[0] : result.split(",");
    }

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};


        String[] reversedNames = reverseStudentNames(students);
        System.out.println("Reversed Names:");
        for (String name : reversedNames) {
            System.out.println(name);
        }


        System.out.println("\nLetter Grades:");
        for (int score : scores) {
            System.out.println(score + " -> " + getLetterGrade(score));
        }


        String[] failing = findFailingStudents(students, scores);
        System.out.println("\nFailing Students:");
        for (String name : failing) {
            System.out.println(name);
        }
    }
}
