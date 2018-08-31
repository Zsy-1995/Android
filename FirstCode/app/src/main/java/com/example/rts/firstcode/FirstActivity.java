package com.example.rts.firstcode;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class FirstActivity extends BaseActivity implements View.OnClickListener{

    private EditText editText;
    private ProgressBar progressBar;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(FirstActivity.this, "add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this, "remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");

                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Log.d("FirstActivity", this.toString());
        Log.d("FirstActivity", "task id is" + getTaskId());
        setContentView(R.layout.first_layout);
        editText = findViewById(R.id.edit_text);
        progressBar = findViewById(R.id.progress_bar);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
//        button3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AlertDialog.Builder dialog = new AlertDialog.Builder(FirstActivity.this);
//                dialog.setTitle("This is Dialog");
//                dialog.setMessage("真香警告⚠");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                    }
//                });
//                dialog.show();
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //点击按钮隐藏进度条，再次点击显示，如此往复
////                if (progressBar.getVisibility() == View.GONE) {
////                    progressBar.setVisibility(View.VISIBLE);
////                } else {
////                    progressBar.setVisibility(View.GONE);
////                }
//                int progress = progressBar.getProgress();
//                progress = progress + 10;
//                progressBar.setProgress(progress);
//
//            }
//        });
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String inputText = editText.getText().toString();
//                Toast.makeText(FirstActivity.this, inputText, Toast.LENGTH_SHORT).show();
//                SecondActivity.actionStart(FirstActivity.this, "data1", "data2");
//
////                String data="Hello Second";
////                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
////                intent.putExtra("extra_data", data);
////                intent.setData(Uri.parse("geo:"));
////                intent.addCategory("com.examle.activitytest.MY_CATEGORY");
////                startActivity(intent);
//            }
//        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                String inputText = editText.getText().toString();
                Toast.makeText(FirstActivity.this, inputText, Toast.LENGTH_SHORT).show();
                SecondActivity.actionStart(FirstActivity.this, "data1", "data2");
                break;
            case R.id.button2:
                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);
                break;
            case  R.id.button3:
                AlertDialog.Builder dialog = new AlertDialog.Builder(FirstActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("真香警告⚠");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.show();
                break;
            case R.id.button4:
                ProgressDialog progressDialog = new ProgressDialog(FirstActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("loading..");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
