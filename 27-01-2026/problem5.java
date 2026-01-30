import java.io.File;
import java.io.FileWriter;
import java.util.*;
import java.util.logging.Logger;

public class problem5 {

    static class InvalidStudentException extends Exception {
        public InvalidStudentException(String message) {
            super(message);
        }
    }
    private static final Logger logger = Logger.getLogger(problem5.class.getName());

    public static void main(String[] args) {

        Scanner sc = null;
        FileWriter validWriter = null;
        FileWriter invalidWriter = null;

        List<String> validStudents = new ArrayList<>();
        Set<Integer> uniqueIds = new HashSet<>();
        Map<Integer, String> studentMap = new HashMap<>();

        try {
            File file = new File("students.txt");
            sc = new Scanner(file);
            validWriter = new FileWriter("valid.txt");
            invalidWriter = new FileWriter("invalid.txt");

            logger.info("Student file reading started");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                try {
                    line = line.trim().replaceAll("\\s+", " ");
                    String[] data = line.split(",");

                    if (data.length != 3) {
                        throw new InvalidStudentException("Wrong format");
                    }

                    Integer id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    Integer age = Integer.parseInt(data[2].trim());

                    if (age < 18) {
                        throw new InvalidStudentException("Age below 18");
                    }

                    if (!uniqueIds.add(id)) {
                        throw new InvalidStudentException("Duplicate student");
                    }

                    // Store valid data
                    String record = id + "," + name + "," + age;
                    validStudents.add(record);
                    studentMap.put(id, record);

                } catch (NumberFormatException e) {
                    invalidWriter.write(line + " -> Invalid number\n");
                } catch (InvalidStudentException e) {
                    invalidWriter.write(line + " -> " + e.getMessage() + "\n");
                }
            }

            //  valid students
            for (String s : validStudents) {
                validWriter.write(s + "\n");
            }

            logger.info("Student processing completed");

        } catch (Exception e) {
            logger.severe("File not found or error occurred");
        } finally {
            try {
                if (sc != null) sc.close();
                if (validWriter != null) validWriter.close();
                if (invalidWriter != null) invalidWriter.close();
                logger.info("Resources closed successfully");
            } catch (Exception e) {
                logger.warning("Error while closing resources");
            }
        }
    }
}
