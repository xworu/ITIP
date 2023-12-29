package lab.java8;

public class Main {
    public static void main(String[] args) {
        DataManager dataManager= new DataManager();

        dataManager.registerDataProcessor(new DataFilter());

        dataManager.loadData("C:\\Users\\User\\IdeaProjects\\untitled\\src\\lab\\java8\\age.txt");
        dataManager.processData();
        dataManager.saveData("C:\\Users\\User\\IdeaProjects\\untitled\\src\\lab\\java8\\result.txt");
    }
}
