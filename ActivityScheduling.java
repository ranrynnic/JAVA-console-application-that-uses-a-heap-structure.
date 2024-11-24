import java.util.PriorityQueue;
import java.util.Scanner;

class Activity implements Comparable<Activity> {
    String name;
    int startTime;  // Start time in seconds
    int endTime;    // End time in seconds (converted from minutes)

    public Activity(String name, int startTime, int endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime * 60;  // Convert end time from minutes to seconds
    }


    public int compareTo(Activity other) {
        // Compare based on end time for min-heap behavior
        return Integer.compare(this.endTime, other.endTime);
    }


    public String toString() {
        return "Activity{name='" + name + "', startTime=" + startTime + " seconds, endTime=" + (endTime / 60) + " minutes}";
    }
}

public class ActivityScheduling {
    public static void main(String[] args) {

        PriorityQueue<Activity> activityQueue = new PriorityQueue<>();

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nActivity Scheduling System");
          		  System.out.println("1. Add Activity");
           				 System.out.println("2. Schedule Next Activity");
           			 System.out.println("3. View All Scheduled Activities");
            	System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    // Add a new activity
                    System.out.print("Enter activity name: ");
                    	String name = scanner.nextLine();
                    System.out.print("Enter activity start time (in seconds): ");
                    	int startTime = scanner.nextInt();
                    System.out.print("Enter activity end time (in minutes): ");
                   	 int endTime = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    activityQueue.add(new Activity(name, startTime, endTime));
                    System.out.println("Activity added successfully!");
                    	break;

                case 2:
                    // Schedule the next activity (the one with the earliest end time)
                    if (!activityQueue.isEmpty()) {
                        Activity nextActivity = activityQueue.poll();
                        System.out.println("Next activity to schedule: " + nextActivity);
                    } else {
                        System.out.println("No activities available for scheduling.");
                    }
                    break;

                case 3:
                    // View all scheduled activities
                    if (!activityQueue.isEmpty()) {
                        System.out.println("All scheduled activities:");
                        for (Activity activity : activityQueue) {
                            System.out.println(activity);
                        }
                    } else {
                        System.out.println("No activities scheduled.");
                    }
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting the system.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
		}
    }
}