package customlistview.example.com.customlistview;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private ListView list;
    int[] logos = new int[] { R.drawable.img001, R.drawable.img002,
            R.drawable.img003 };
    String[] names = new String[] { "超級球", "高級球", "珍貴球" };
    String[] lists = new String[] { "Great Ball", "Ultra Ball", "Cherish Ball" };

    MyAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = (ListView) findViewById(R.id.list);

        adapter = new MyAdapter(this);

        list.setAdapter(adapter);
    }

    public class MyAdapter extends BaseAdapter {
        private LayoutInflater myInflater;

        public MyAdapter(Context c) {
            myInflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            convertView = myInflater.inflate(R.layout.mylist, null);

            ImageView logo = (ImageView) convertView.findViewById(R.id.imglogo);
            TextView name = (TextView) convertView.findViewById(R.id.name);
            TextView list = (TextView) convertView
                    .findViewById(R.id.txtengname);

            logo.setImageResource(logos[position]);
            name.setText(names[position]);
            list.setText(lists[position]);

            return convertView;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return true;
    }

}
