package misao.edu.email;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText to,subject,message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        to = findViewById( R.id.editText );
        subject = findViewById( R.id.etSubject );
        message = findViewById( R.id.etMessage );
        send = findViewById( R.id.submit );

        send.setOnClickListener( this );

    }

    @Override
    public void onClick(View view) {

        String email = to.getText().toString();
        String sub = subject.getText().toString();
        String msg = message.getText().toString();

        Intent intent = new Intent( Intent.ACTION_SEND );
        intent.putExtra( Intent.EXTRA_EMAIL,new String[]{ email} );
        intent.putExtra( Intent.EXTRA_SUBJECT, sub );
        intent.putExtra( Intent.EXTRA_TEXT,msg );

        //need this to promts email client only
        intent.setType( "message/rfc822" );

        startActivity( Intent.createChooser( intent,"Choose an Email client :" ) );
    }
}

/*
.xmlにメールのフォーマットをEditTextとButtonで作成(メルアド,題名,内容文)
それぞれ宣言、初期化、setOnClickListenerで継承、@Override
欲しい情報をgetText().toString();で得る
Intent.ACTION_SENDで他のアプリケーションと連携
変数.putExtraでEXTRA_EMAIL,で遷移する情報をputExtraに入れる
( "message/rfc822" )で他のアプリケーションへメールを送る


 */