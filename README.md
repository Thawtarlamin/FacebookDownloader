# FacebookDownloader
> Facebook က video များအား SD HDဒေါင်းနိုင်အောင်ရည်ရွယ်၍ ထုတ်ပေးထားပါသည်။
# Usage Library
>settings.gradle ထည့်‌ပေးပါ

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
>build.gradle ထည့်‌ပေးပါ
```
dependencies {
	        implementation 'com.github.Thawtarlamin:FacebookDownloader:1.0'
	}
```

>MainActivity.java
```
        new FacebookDownloader("", MainActivity.this, new FacebookDownloader.onComplete() {
            @Override
            public void onComplete(XModal xModal) {
                Log.d(TAG, "SDLink: "+xModal.getSdlink());
                Log.d(TAG, "HDLink: "+xModal.getHdlink());
                Log.d(TAG, "Desc: "+xModal.getDesc());
                Log.d(TAG, "Title: "+xModal.getTitle());
                Log.d(TAG, "Thumb: "+xModal.getThumb());
            }
        }, new FacebookDownloader.onError() {
            @Override
            public void onError(Exception error) {

            }
        });
```

> အသုံးပြုသူများအဆ‌င်ပြေစေရန်ရည်ရွယ်၍ ထုတ်ပေးထားခြင်းဖြစ်ပါသည်။

# Creator By Thaw Tar La Minn


# 😘😘😘😘
# Donate Paypal
```
nyeineikhin.nek@gmail.com
```

>Thank you for  All User
