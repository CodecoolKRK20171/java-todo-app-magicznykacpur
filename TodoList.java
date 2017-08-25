import java.util.*;

public class TodoList
{
  List<TodoItem> todoList = new ArrayList<TodoItem>();

  public TodoList() {;}

  public void addToList(TodoItem item) {
    this.todoList.add(item);
  }

  public TodoItem getItem(String title)
  {
    TodoItem item = null;

    for(int i = 0; i < todoList.size(); i++)
    {
      if (todoList.get(i).title.equals(title))
      {
        item = todoList.get(i);
        return item;
      }
      else
      {
        System.out.println("No such item on this list.");
        return null;
      }
    }
    return null;
  }

  public void removeFromlist(String title)
  {
    for(int i = 0; i < todoList.size(); i++)
    {
      if (todoList.get(i).title.equals(title))
      {
        todoList.remove(i);
        break;
      }
      else
      System.out.println("No such item on this list.");
    }
  }

  public void archive()
  {
    for (Iterator<TodoItem> iterator = this.todoList.iterator(); iterator.hasNext();)
    {
      TodoItem item = iterator.next();
      if(item.isDone) iterator.remove();
    }
  }

  public void listItems()
  {
    if(!todoList.isEmpty())
    {
      for(int i = 0; i < todoList.size(); i++)
      {
        System.out.println(todoList.get(i));
      }
    } else
    System.out.println("List is empty.");

  }
}
