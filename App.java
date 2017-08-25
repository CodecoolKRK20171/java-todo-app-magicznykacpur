import java.util.*;

public class App{

  TodoList itemList;

  public static String menu()
  {
    clearConsole();
    System.out.println("Welcome to the ToDoApp.");
    System.out.println("1. List items.");
    System.out.println("2. Archive items.");
    System.out.println("3. Add item.");
    System.out.println("4. Mark item as done.");
    System.out.println("5. Mark item as undone.");
    System.out.println("0. Exit.");
    String userChoice = getInput("Select an option: ");

    return userChoice;
  }

  public void initalizeItemList()
  {
    itemList = new TodoList();
  }

  public static String getInput(String message)
  {
    Scanner reader = new Scanner(System.in);
    System.out.println(message);
    String input = reader.nextLine();

    return input;
  }

  public static String getTitle()
  {
    String title = getInput("Enter the title of the task: ");
    return title;
  }

  public static void clearConsole()
  {
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }

  public static void pause()
  {
    Scanner r = new Scanner(System.in);
    System.out.println("Press enter to continue ");
    String tempString = r.nextLine();
  }

  public static TodoItem createItemByTitle()
  {
    String titleToGet = getTitle();
    TodoItem item = new TodoItem(titleToGet, false);
    return item;
  }

  public static void markAsDone(TodoList itemList)
  {
    TodoItem toMark = itemList.getItem(getTitle());
    if(toMark != null)
    {
      toMark.markisDone();
    }
    else
    {
      System.out.println("There's no such item.");
    }
  }

  public static void markAsUndone(TodoList itemList)
  {
    TodoItem toUnMark = itemList.getItem(getTitle());
    if(toUnMark != null)
    {
      toUnMark.unmarkisDone();
    }
    else
    {
      System.out.println("There's no such item.");
    }
  }

  public static void handleApp(TodoList itemList)
  {
    String userChoice = null;

    while(true)
    {
      userChoice = menu();
      if(userChoice.equals("1"))
      {
        itemList.listItems();
        pause();
      } else if(userChoice.equals("2"))
      {
        itemList.archive();
      } else if(userChoice.equals("3"))
      {
        TodoItem item = createItemByTitle();
        itemList.addToList(item);
      } else if(userChoice.equals("4"))
      {
        markAsDone(itemList);
      } else if(userChoice.equals("5"))
      {
        markAsUndone(itemList);
      } else if(userChoice.equals("0"))
      {
        System.exit(0);
      }
    }
  }

  public static void main(String[] args)
  {
    App app = new App();
    app.initalizeItemList();
    handleApp(app.itemList);
  }
}
