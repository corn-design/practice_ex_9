import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;
public class OrderLogs{
    
    private ArrayDeque<String> orderLogs = new ArrayDeque<String>();
    
    public OrderLogs(){
        orderLogs = new ArrayDeque<String>();
    }
    public void addOrder(String log){
        orderLogs.push(log);
    }
    private void mostRecentLogEntry() {
        if (!orderLogs.isEmpty()) {
            System.out.println(orderLogs.peek());
        } else {
            System.out.println("栈为空");
        }
    }

    // 移除栈顶元素并返回其值的私有方法
    private String getOrderLog() {
        return orderLogs.pop();
    }

    // 清空栈中所有日志的私有方法
    private void removeAllLogEntries() {
        orderLogs.clear();
    }

    // 检查栈是否为空的私有方法
    private boolean orderLogsEmpty() {
        return orderLogs.isEmpty();
    }

    // 处理用户与日志交互的公共方法
    public void handleLogs() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose what you want to do with order logs:");
            System.out.println("1. Display all the logs");
            System.out.println("2. Display the most recent logs");
            System.out.println("3. Remove a log entry");
            System.out.println("4. Remove all log entries");
            System.out.println("5. Check if the log is completely empty");
            System.out.print("Enter your choice (1 - 5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayOrderLogs();
                    break;
                case 2:
                    if (!orderLogsEmpty()) {
                        mostRecentLogEntry();
                    } else {
                        System.out.println("栈为空");
                    }
                    break;
                case 3:
                    if (!orderLogsEmpty()) {
                        getOrderLog();
                        System.out.println("日志已移除");
                    } else {
                        System.out.println("栈为空");
                    }
                    break;
                case 4:
                    removeAllLogEntries();
                    System.out.println("所有日志已移除");
                    break;
                case 5:
                    if (orderLogsEmpty()) {
                        System.out.println("The log is completely empty");
                    } else {
                        System.out.println("The log is not completely empty");
                    }
                    break;
                default:
                    System.out.println("无效选择，请重新输入");
            }
        }
    }

    // 显示所有日志的方法（题目中未明确要求，但在handleLogs中用到）
    private void displayOrderLogs() {
        for (String log : orderLogs) {
            System.out.println(log);
        }
    }
}