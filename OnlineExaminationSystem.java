import java.util.*;

public class OnlineExaminationSystem {

    private HashMap<String, List<Question>> questions;

    public OnlineExaminationSystem() {
        this.questions = new HashMap<>();
    }

    public void addQuestion(String subject, Question question) {
        if (!questions.containsKey(subject)) {
            questions.put(subject, new ArrayList<>());
        }
        questions.get(subject).add(question);
    }

    public List<Question> getQuestions(String subject) {
        return questions.get(subject);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        OnlineExaminationSystem examinationSystem = new OnlineExaminationSystem();

        while (true) {
            System.out.println("Welcome to the online examination system. What would you like to do?");
            System.out.println("1. Take an exam");
            System.out.println("2. View your results");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the subject you would like to take an exam for: ");
                    String subject = scanner.next();

                    List<Question> questions = examinationSystem.getQuestions(subject);

                    if (questions != null) {
                        int score = 0;
                        for (Question question : questions) {
                            System.out.println(question.getQuestion());
                            for (String answer : question.getAnswers()) {
                                System.out.println("* " + answer);
                            }
                            System.out.println("Enter your answer: ");
                            String userAnswer = scanner.next();
                            if (userAnswer.equals(question.getCorrectAnswer())) {
                                score++;
                            }
                        }
                        System.out.println("Your score is " + score);
                    } else {
                        System.out.println("There are no questions for the selected subject.");
                    }
                    break;
                case 2:
                    System.out.println("Enter your student ID: ");
                    String studentId = scanner.next();

                    List<Result> results = examinationSystem.getResults(studentId);

                    if (results != null) {
                        for (Result result : results) {
                            System.out.println("Subject: " + result.getSubject());
                            System.out.println("Score: " + result.getScore());
                        }
                    } else {
                        System.out.println("You have not taken any exams yet.");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the online examination system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
