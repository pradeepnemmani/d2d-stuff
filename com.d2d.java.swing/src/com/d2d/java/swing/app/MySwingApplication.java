package com.d2d.java.swing.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MySwingApplication extends JFrame
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MySwingApplication( String title ) throws HeadlessException
    {
        super( title );
        initializeApp();
    }

    protected void initializeApp()
    {
        JPanel panel = new JPanel();
        panel.setLayout( new BorderLayout() );
        panel.setComponentOrientation( ComponentOrientation.LEFT_TO_RIGHT );
        // Default layout for JPanel is FlowLayout
        JSplitPane sp = createMainContent();
        if ( sp != null )
        {
            panel.add( sp, BorderLayout.CENTER );
        }
        // Now set the panel as the content pane
        setContentPane( panel );
        // Create the jmenubar
        JMenuBar mb = createJMenuBar();
        if ( mb != null )
        {
            setJMenuBar( mb );
        }
    }

    protected JSplitPane createMainContent()
    {
        JSplitPane sp = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        sp.setSize( new Dimension( 400, 400 ) );
        sp.setDividerLocation( 0.40 );
        sp.setDividerSize( 5 );

        // Left side container
        JPanel leftPanel = createLeftContainer();
        if ( leftPanel != null )
        {
            sp.setLeftComponent( leftPanel );
        }

        // Right side container
        JPanel rightPanel = createRightContainer();
        if ( rightPanel != null )
        {
            sp.setRightComponent( rightPanel );
        }

        return sp;
    }

    protected JPanel createLeftContainer()
    {
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground( Color.WHITE );

        return leftPanel;
    }

    protected JPanel createRightContainer()
    {
        JPanel rightPanel = new JPanel();

        rightPanel.setLayout( new GridBagLayout() );

        // rightPanel.setLayout( new BorderLayout( 5, 5 ) );
        rightPanel.setBackground( Color.WHITE );

        // Create the button panel
        JPanel buttonPanel = createButtonPanel();
        if ( buttonPanel != null )
        {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 5;
            gbc.gridheight = 1;
            gbc.weighty = 15;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.SOUTH;
            rightPanel.add( buttonPanel, gbc );
        }

        // Create the album creation form
        JPanel formPanel = createAlbumForm();
        if ( formPanel != null )
        {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 5;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 85;
            rightPanel.add( formPanel, gbc );
        }

        return rightPanel;

    }

    protected JPanel createAlbumForm()
    {
        JPanel form = new JPanel();
        // form.setSize( 400, 400 );
        form.setOpaque( false );

        GridBagLayout layout = new GridBagLayout();
        form.setLayout( layout );

        // Label & Text field for album name
        JLabel nameLabel = new JLabel( "Name:" );

        // Add the nameLabel to the form.
        // Create the GridBagConstraints object and specify
        // constraints for nameLabel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.ipadx = 2;
        gbc.ipady = 2;

        form.add( nameLabel, gbc );

        // TextField
        JTextField nameTextField = new JTextField( 24 );
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridheight = 1;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.ipadx = 2;
        gbc.ipady = 2;
        form.add( nameTextField, gbc );

        // Category & Text field for album name
        JLabel categoryLabel = new JLabel( "Category:" );

        // Add the nameLabel to the form.
        // Create the GridBagConstraints object and specify
        // constraints for nameLabel
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.ipadx = 2;
        gbc.ipady = 2;

        form.add( categoryLabel, gbc );

        // TextField
        JTextField categoryTextField = new JTextField( 24 );
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridheight = 1;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.ipadx = 2;
        gbc.ipady = 2;
        form.add( categoryTextField, gbc );

        // Duration & Text field for album name
        JLabel durationLabel = new JLabel( "Duration:" );

        // Add the nameLabel to the form.
        // Create the GridBagConstraints object and specify
        // constraints for nameLabel
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.ipadx = 2;
        gbc.ipady = 2;

        form.add( durationLabel, gbc );

        // TextField
        JTextArea durationTextArea = new JTextArea( 6, 24 );
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridheight = 1;
        gbc.insets = new Insets( 5, 5, 5, 5 );
        gbc.ipadx = 2;
        gbc.ipady = 2;
        form.add( new JScrollPane( durationTextArea ), gbc );

        return form;
    }

    protected JPanel createButtonPanel()
    {
        JPanel buttonPanel = new JPanel();
        // Button 1
        JButton okButton = new JButton( "OK" );
        // Button 3
        JButton cancelButton = new JButton( "Cancel" );
        // Add the buttons to the panel which acts as our content pane
        buttonPanel.add( okButton );
        buttonPanel.add( cancelButton );
        return buttonPanel;
    }

    protected JMenuBar createJMenuBar()
    {
        JMenuBar mb = new JMenuBar();
        // Delegate to createFileMenu
        JMenu fileMenu = createFileMenu();
        if ( fileMenu != null )
        {
            mb.add( fileMenu );
        }

        // Delegate to createEditMenu
        JMenu editMenu = createEditMenu();
        if ( editMenu != null )
        {
            mb.add( editMenu );
        }

        return mb;
    }

    protected JMenu createFileMenu()
    {
        // Create a File Menu
        JMenu fileMenu = new JMenu( "File" );
        // Create the New menu item
        JMenu fileNewMenu = createFileNewMenu();
        if ( fileNewMenu != null )
        {
            fileMenu.add( fileNewMenu );
        }
        // Add a separator
        fileMenu.add( new JSeparator( JSeparator.HORIZONTAL ) );
        // Create the Exit menu item
        JMenuItem exitMenuItem = new JMenuItem( "Exit" );
        fileMenu.add( exitMenuItem );
        return fileMenu;
    }

    protected JMenu createFileNewMenu()
    {
        JMenu fileNewMenu = new JMenu( "New" );
        // Create the New class menu item
        JMenuItem fileNewClassMenuItem = new JMenuItem( "Class" );
        JMenuItem fileNewFileMenuItem = new JMenuItem( "File" );
        JMenuItem fileNewFolderMenuItem = new JMenuItem( "Folder" );
        fileNewMenu.add( fileNewClassMenuItem );
        fileNewMenu.add( fileNewFileMenuItem );
        fileNewMenu.add( fileNewFolderMenuItem );
        return fileNewMenu;
    }

    protected JMenu createEditMenu()
    {
        // Create Edit menu
        JMenu editMenu = new JMenu( "Edit" );
        // Create Cut MenuItem
        JMenuItem cutMenuItem = new JMenuItem( "Cut" );
        // Create Copy MenuItem
        JMenuItem copyMenuItem = new JMenuItem( "Copy" );
        // Create Paste MenuItem
        JMenuItem pasteMenuItem = new JMenuItem( "Paste" );
        // Add the menu items to edit
        editMenu.add( cutMenuItem );
        editMenu.add( copyMenuItem );
        editMenu.add( pasteMenuItem );

        return editMenu;
    }

    @Override
    public void setVisible( boolean b )
    {
        setSize( new Dimension( 600, 600 ) );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocationRelativeTo( null );
        super.setVisible( b );
        System.out.println( Thread.currentThread().getName() );
    }

    public static void main( String[] args )
    {
        System.out.println( Thread.currentThread().getName() );

        Runnable displayAppRunnable = new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" );
                }
                catch ( Exception e )
                {
                    e.printStackTrace();
                }
                MySwingApplication app = new MySwingApplication( "My first swing application" );
                System.out.println( "Making the application visible" );
                app.setVisible( true );
            }
        };
        SwingUtilities.invokeLater( displayAppRunnable );

        System.out.println( "Returning from main" );
    }
}
