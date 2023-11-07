package edu.utsa.cs3443.ebookreader;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import edu.utsa.cs3443.ebookreader.model.EBook;

public class BookActivity extends AppCompatActivity {

    private EBook book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        String bookName = getIntent().getStringExtra(MainActivity.getKey());
        //use the String bookName to retrieve the EBook object
        book = MainActivity.getClickedBook(bookName);
        //set up the ImageView
        displayCoverImage();
        //set up the TextView for title
        displayTitle();
        //set up the TextView for content
        displayText();
    }

    private void displayCoverImage(){
        //Step 1: Create a local variable for imageView and wire it up with the ImageView from xml file
        ImageView imView = (ImageView) findViewById(R.id.book_cover);
        //Step 2: Get the location where the image for this specific book is stored
        int imageResource = getResources().getIdentifier(book.getBookCover(), "drawable", getPackageName());
        //Step 3: Set the imageResource ID for the imView
        imView.setImageResource(imageResource);
    }

    private void displayTitle(){
        //Step 1: Create a TextView local variable and wire it with TextView in the xml file
        TextView txViewTitle = (TextView) findViewById(R.id.book_title);
        //Step 2: Get the title of the current EBook object and set it for the textview
        txViewTitle.setText(book.getTitle());
    }

    private void displayText(){
        //step 1: Create a TextView local variable and wire it with the content Textview in XmL
        TextView txViewContent = (TextView) findViewById(R.id.book_text);
        //Step 2: Load the content of this book from its asset file and set it for the textView
        txViewContent.setText(book.readBook(this));
    }
}