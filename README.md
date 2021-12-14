# Laba11
Laba 11 Mobilki (TepluhinLev 803a2)
1) Создаём проект
2) Помещяаем на форму 2 компонента типа TextEdit – один для ввода
телефонного номера, другой для ввода текста СМС-сообщения
3) Помещяаем на форму 2 компонента типа Button – один для кнопки
«Звонок», другой для кнопки «СМС».

![image](https://user-images.githubusercontent.com/73265867/146045973-caa40b4e-65e2-4acf-a407-3cc210d93b51.png)

4) Добавим разрешения на осуществления вызова и отправки СМС в
файле AndroidManifest.xml

![image](https://user-images.githubusercontent.com/73265867/146046196-73eba47d-9e53-4470-afd0-5fc9cebdc882.png)

5) Добавляем обработчик события по кнопке «Отправить сообщение»:
```Java
public void onSms(View view) {
        EditText edit_Number=(EditText)findViewById(R.id.editTextPhone);
        String phoneNo = edit_Number.getText().toString();
        EditText sms_edit=(EditText)findViewById(R.id.editTextTextMultiLine2);
        String toSms="smsto:"+edit_Number.getText().toString();
        String messageText= sms_edit.getText().toString();
        Intent sms=new Intent(Intent.ACTION_SENDTO, Uri.parse(toSms));
        sms.putExtra("sms_body", messageText);
        startActivity(sms);
        SmsManager.getDefault().sendTextMessage(phoneNo, null,
                messageText.toString(), null, null);
    }
```

6) Внесим изменения в функцию «onCreate»:
```Java
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mDialButton = (Button) findViewById(R.id.button2);
        final EditText mPhoneNoEt = (EditText)
                findViewById(R.id.editTextPhone);
        final EditText smsEdit = (EditText) findViewById(R.id.editTextTextMultiLine2);
        mDialButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String phoneNo = mPhoneNoEt.getText().toString();
                if(!TextUtils.isEmpty(phoneNo))
                {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_CALL,
                            Uri.parse(dial)));
                }
                else {
                    Toast.makeText(MainActivity.this, "Введите номер телефона",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
```
7) В activity_main.xml поигрался с дизайном кнопок и добавил фон (обработанный в фотошопе) :)

<EditText
        android:id="@+id/editTextPhone"
        android:layout_width="239dp"
        android:layout_height="45dp"
        android:layout_marginStart="88dp"
        android:layout_marginTop="184dp"
        android:ems="10"
        android:hint="Введите номер телефона"
        android:inputType="phone"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <EditText
        android:id="@+id/editTextTextMultiLine2"
        android:layout_width="239dp"
        android:layout_height="44dp"
        android:layout_marginStart="88dp"
        android:layout_marginTop="252dp"
        android:ems="10"
        android:gravity="start|top"
        android:hint="Введите сообщение"
        android:inputType="textMultiLine"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button"
        style="@style/Widget.MaterialComponents.Button.TextButton.Icon"
        android:layout_width="239dp"
        android:layout_height="55dp"
        android:layout_marginStart="88dp"
        android:layout_marginTop="324dp"
        android:onClick="onSms"
        android:text="Отправить сообщение"
        app:icon="@drawable/sms1_add_24dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/button2"
        style="@style/Widget.MaterialComponents.Button.TextButton.Icon"
        android:layout_width="239dp"
        android:layout_height="55dp"
        android:layout_marginStart="88dp"
        android:layout_marginTop="400dp"
        android:onClick="onSms"
        android:text="Позвонить"
        app:icon="@drawable/call1_add_24dp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
        
 8) Запускаем и проверяем приложение:
 
 ![image](https://user-images.githubusercontent.com/73265867/146047423-e0919611-0b55-461e-845d-ee6bc16f76f5.png)
 
 9) Вводим номер телефона "555" и сообщение "privet" и нажимаем кнопку отправить:
 
 ![image](https://user-images.githubusercontent.com/73265867/146047596-f9fff58f-e994-4e7b-8288-0ae4172463c2.png)
 
 9) Все работает!) Номер ввелся и сообщение тоже:
 
 ![image](https://user-images.githubusercontent.com/73265867/146047739-3697a173-1f82-4bb6-a28b-ff70a7233b56.png)


        
