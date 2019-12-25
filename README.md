# test_destroy
A Flutter project for testing prewarm FlutterEngine.

**This project show how FlutterEngine crashes on Android!**

## Reproduce

### Requirements
1. Checkout Flutter to 1.12.13+hotfix.5 on stable channel
2. Clone this project
3. Connected to Android phone

### Steps
1. Run `flutter run --release`
2. Click button "prewarm engine"
3. Click button "open flutter with prewarm engine"
4. Pop to home
5. Click button "destroy prewarmed engine"
6. FlutterEngine crashes

### Logs

<details>
<summary>********** Crash dump: **********</summary>
<pre>
Build fingerprint: 'HUAWEI/VOG-AL10/HWVOG:9/HUAWEIVOG-AL10/9.1.0.226C00:user/release-keys'
#00 0x000000000062d6e0 /data/app/com.example.test_destroy-XhnDtc7qXNgt8LGjiwF_8g==/lib/arm64/libflutter.so (offset 0x270000)
  std::__1::unique_ptr<dart::ThreadRegistry, std::__1::default_delete<dart::ThreadRegistry> >::operator->() const
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/libcxx/include/memory:2562:19
  dart::IsolateGroup::threads_lock() const
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/dart/runtime/vm/isolate.cc:3268:0
  dart::Isolate::ScheduleThread(bool, bool)
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/dart/runtime/vm/isolate.cc:3277:0
  dart::Thread::EnterIsolate(dart::Isolate*)
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/dart/runtime/vm/thread.cc:311:0
#01 0x00000000006a26ec /data/app/com.example.test_destroy-XhnDtc7qXNgt8LGjiwF_8g==/lib/arm64/libflutter.so (offset 0x270000)
  Dart_EnterIsolate
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/dart/runtime/vm/dart_api_impl.cc:1366:8
#02 0x00000000004c66f4 /data/app/com.example.test_destroy-XhnDtc7qXNgt8LGjiwF_8g==/lib/arm64/libflutter.so (offset 0x270000)
  tonic::DartPersistentValue::Clear()
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/tonic/dart_persistent_value.cc:46:20
#03 0x0000000000290000 /data/app/com.example.test_destroy-XhnDtc7qXNgt8LGjiwF_8g==/lib/arm64/libflutter.so (offset 0x270000)
  std::__1::function<void ()>::operator()() const
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/libcxx/include/functional:2419:12
  fml::MessageLoopImpl::FlushTasks(fml::FlushType)
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../flutter/fml/message_loop_impl.cc:123:0
  fml::MessageLoopImpl::RunExpiredTasksNow()
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../flutter/fml/message_loop_impl.cc:133:0
#04 0x00000000002926ec /data/app/com.example.test_destroy-XhnDtc7qXNgt8LGjiwF_8g==/lib/arm64/libflutter.so (offset 0x270000)
  fml::MessageLoopAndroid::OnEventFired()
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../flutter/fml/platform/android/message_loop_android.cc:92:5
  fml::MessageLoopAndroid::MessageLoopAndroid()::$_0::operator()(int, int, void*) const
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../flutter/fml/platform/android/message_loop_android.cc:42:0
  fml::MessageLoopAndroid::MessageLoopAndroid()::$_0::__invoke(int, int, void*)
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../flutter/fml/platform/android/message_loop_android.cc:40:0
#05 0x00000000000142cc /system/lib64/libutils.so (android::Looper::pollInner(int)+932)
#06 0x0000000000013e8c /system/lib64/libutils.so (android::Looper::pollOnce(int, int*, int*, void**)+60)
#07 0x0000000000012278 /system/lib64/libandroid.so (ALooper_pollOnce+96)
#08 0x0000000000292808 /data/app/com.example.test_destroy-XhnDtc7qXNgt8LGjiwF_8g==/lib/arm64/libflutter.so (offset 0x270000)
  fml::MessageLoopAndroid::Run()
/b/s/w/ir/cache/builder/src/out/android_release_arm64/../../flutter/fml/platform/android/message_loop_android.cc:68:18
#09 0x000000000028f1d8 /data/app/com.example.test_destroy-XhnDtc7qXNgt8LGjiwF_8g==/lib/arm64/libflutter.so (offset 0x270000)
  fml::MessageLoopImpl::DoRun()
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../flutter/fml/message_loop_impl.cc:0:7
  fml::MessageLoop::Run()
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../flutter/fml/message_loop.cc:49:0
#10 0x0000000000291290 /data/app/com.example.test_destroy-XhnDtc7qXNgt8LGjiwF_8g==/lib/arm64/libflutter.so (offset 0x270000)
  fml::Thread::Thread(std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char> > const&)::$_0::operator()() const
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../flutter/fml/thread.cc:34:10
  decltype(std::__1::forward<fml::Thread::Thread(std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char> > const&)::$_0>(fp)()) std::__1::__invoke<fml::Thread::Thread(std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char> > const&)::$_0>(fml::Thread::Thread(std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char> > const&)::$_0&&)
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/libcxx/include/type_traits:3530:0
  void std::__1::__thread_execute<std::__1::unique_ptr<std::__1::__thread_struct, std::__1::default_delete<std::__1::__thread_struct> >, fml::Thread::Thread(std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char> > const&)::$_0>(std::__1::tuple<std::__1::unique_ptr<std::__1::__thread_struct, std::__1::default_delete<std::__1::__thread_struct> >, fml::Thread::Thread(std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char> > const&)::$_0>&, std::__1::__tuple_indices<>)
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/libcxx/include/thread:341:0
  void* std::__1::__thread_proxy<std::__1::tuple<std::__1::unique_ptr<std::__1::__thread_struct, std::__1::default_delete<std::__1::__thread_struct> >, fml::Thread::Thread(std::__1::basic_string<char, std::__1::char_traits<char>, std::__1::allocator<char> > const&)::$_0> >(void*)
  /b/s/w/ir/cache/builder/src/out/android_release_arm64/../../third_party/libcxx/include/thread:351:0
#11 0x0000000000083588 /system/lib64/libc.so (__pthread_start(void*)+36)
#12 0x00000000000241dc /system/lib64/libc.so (__start_thread+68)
</pre>
</details>

## Workaround

- Do not spawn an `Isolate` in dart `main()` entry point if you want prewarm FlutterEngine

- Shutdown `Isolate` before destroying FlutterEngine
