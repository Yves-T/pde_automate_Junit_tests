package phonebookexample.dialogs;


import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
@org.junit.runner.RunWith(org.junit.runners.Suite.class)
@org.junit.runners.Suite.SuiteClasses({ PhoneBookEntryEditorDialogTest.class })
public class TestSuite {

  public static Test suite() {
    return new JUnit4TestAdapter(TestSuite.class);
  }
}
