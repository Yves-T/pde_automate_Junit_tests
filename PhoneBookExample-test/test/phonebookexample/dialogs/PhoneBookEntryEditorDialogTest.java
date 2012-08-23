package phonebookexample.dialogs;

import junit.framework.TestCase;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import phonebookexample.data.PhoneBookEntry;
@RunWith(JUnit4.class)
public class PhoneBookEntryEditorDialogTest extends TestCase {
    MyPhoneBookEntryEditorDialog dialog;
    PhoneBookEntry phoneBookEntry;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        phoneBookEntry = new PhoneBookEntry("john doe", "01234567891011");
        openDialog(phoneBookEntry);
    }

    @After
    public void tearDown() throws Exception {
        dialog.close();
        dialog = null;
        super.tearDown();
    }
    
    private void openDialog(PhoneBookEntry entry) {
        if (dialog != null) {
            dialog.close();
        }
        dialog = new MyPhoneBookEntryEditorDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), entry);
        dialog.setBlockOnOpen(false);
        dialog.open();
    }    

    @Test
    public void atestDialogTitle() throws Exception {
        assertEquals("Phone Book Entry Editor", dialog.getShell().getText());
    }

    @Test
    public void atestInitialDialog() throws Exception {
        assertEquals("Wrong value for name field", "john doe", dialog.nameText.getText());
        assertEquals("Wrong value for number field","01234567891011", dialog.numberText.getText());
        assertVisibleEnabled(dialog.nameText, "nameText", true, true);
        assertVisibleEnabled(dialog.numberText, "numberText", true, true);
        assertVisibleEnabled(dialog.getButton(IDialogConstants.OK_ID), "OK Button", true, true);
        assertVisibleEnabled(dialog.getButton(IDialogConstants.CANCEL_ID), "Cancel Button", true, true);
    }
    
    @Test
    public void atestInvalidNumberDisablesOKButton() throws Exception {
        dialog.numberText.setText("not a number");
        assertVisibleEnabled(dialog.getButton(IDialogConstants.OK_ID), "OK Button", true, false);
        assertVisibleEnabled(dialog.getButton(IDialogConstants.CANCEL_ID), "Cancel Button", true, true);
    }
    
    @Test
    public void atestValidNumberEnablesOKButton() throws Exception {
        dialog.numberText.setText("not a number");
        dialog.numberText.setText("010101");
        assertVisibleEnabled(dialog.getButton(IDialogConstants.OK_ID), "OK Button", true, true);
        assertVisibleEnabled(dialog.getButton(IDialogConstants.CANCEL_ID), "Cancel Button", true, true);
    }
    
    @Test
    public void atestChangingNameUpdatesPhoneBookEntryData() throws Exception {
        dialog.nameText.setText("Jane Dough");
        assertEquals("Jane Dough", dialog.getPhoneBookEntry().getName());
    }
    
    @Test
    public void atestChangingNumberUpdatesPhoneBookEntryData() throws Exception {
        dialog.numberText.setText("01");
        assertEquals("01", dialog.getPhoneBookEntry().getNumber());
    }
    
    
    // Test utilities
    public static void assertEnabled(Control control, String name, boolean expected) {
        assertEquals("Wrong enabled setting for " + name, expected, control.isEnabled());
    }
    
    public static void assertVisible(Control control, String name, boolean expected) {
        assertEquals("Wrong visible setting for " + name, expected, control.isVisible());
    }
    
    public static void assertVisibleEnabled(Control control, String name, boolean expectedVisible, boolean expectedEnabled) {
        assertVisible(control, name, expectedVisible);
        assertEnabled(control, name, expectedEnabled);
    }
    
        
    // extend class under test to get access in the test to some protected methods
    class MyPhoneBookEntryEditorDialog extends PhoneBookEntryEditorDialog {
        public MyPhoneBookEntryEditorDialog(Shell parent, PhoneBookEntry phoneBookEntry) {
            super(parent, phoneBookEntry);
        }

        @Override
        protected void buttonPressed(int buttonId) {
            super.buttonPressed(buttonId);
        }
        
        @Override
        protected void cancelPressed() {
            super.cancelPressed();
        }

        @Override
        protected Button getButton(int id) {
            return super.getButton(id);
        }
    }
}
