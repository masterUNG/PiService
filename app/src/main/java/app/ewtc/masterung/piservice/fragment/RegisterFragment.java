package app.ewtc.masterung.piservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

import app.ewtc.masterung.piservice.MainActivity;
import app.ewtc.masterung.piservice.R;
import app.ewtc.masterung.piservice.utility.MyAlert;

/**
 * Created by masterung on 31/10/2017 AD.
 */

public class RegisterFragment extends Fragment {

//    Explicit การประกาศตัวแปร
    private String nameString, genderString, userString, passwordString;

    // Status of Gender true ==> ยังไม่ได้เลือกเพศ
    // false ==> มีการเลือก male หรือ female แล้ว
    private boolean aBoolean = true;


    //    Create Main Method คือ เมธอดที่ ทำหน้าที่ เป็น ผู้จัดการ
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create Toolbar
        createToolbar();

//        Save Controller
        saveController();

//        Gender Controller
        genderController();

    }   // Main Method

    private void genderController() {
        RadioGroup radioGroup = getView().findViewById(R.id.ragGender);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                aBoolean = false;
                switch (checkedId) {
                    case R.id.radMale:
                        genderString = "Male";
                        break;
                    case R.id.radFemale:
                        genderString = "Female";
                        break;
                }
            }
        });
        

    }

    private void saveController() {
        ImageView imageView = getView().findViewById(R.id.imvSave);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Initial View
                EditText nameEditText = getView().findViewById(R.id.edtName);
                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

//                Get Value From EditText To String
//                คือการรับค่าจาก ตัวแปร EditText ไปเป็น String
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

//                Check Space
                if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
                    // Work When Condition is True ==> Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.title_have_space),
                            getString(R.string.message_have_space));
                } else if (aBoolean) {
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.myDialog(getString(R.string.title_gender),
                            getString(R.string.message_gender));
                } else {
                }

            }   // onClick
        });
    }

    private void createToolbar() {

//        Initial View  คือการ Inflater View เข้ามาทำงาน ใน Java
        Toolbar toolbar = getView().findViewById(R.id.toolbarRegister);

//        Setup Toolbar คือการกำหนดให้ Toolbar ทำงาน
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

//        Setup Title of Toolbar คือการ เปลี่ยน Title ของ Toolbar
        ((MainActivity) getActivity())
                .getSupportActionBar()
                .setTitle(getResources().getString(R.string.new_register));

//        Visible Button Back
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                คือการสลาย Fragment Register และ กลับไปที่หน้าที่มา
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


    }

    //    เมธอด ที่ใช่ในการสร้าง หน้ากาก
//    Create Fragment
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);

        return view;
    }
}   // Main Class
