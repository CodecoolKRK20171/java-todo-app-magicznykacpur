import java.util.*;

public class TodoItem
{
  String title;
  boolean isDone;

  public TodoItem(String title, boolean is_done)
  {
    this.title = title;
    this.isDone = false;
  }

  public void markisDone()
  {
    this.isDone = true;
  }

  public void unmarkisDone()
  {
    this.isDone = false;
  }

  public String getTitle()
  {
    return this.title;
  }

  public boolean getisDone()
  {
    return this.isDone;
  }

  public String toString()
  {
    String todoItem = "";

    if (this.isDone)
    {
      return todoItem = String.join(" ", "[X]", this.title);
    }
    else
      return todoItem = String.join(" ", "[ ]", this.title);
  }
}
