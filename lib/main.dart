import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:executor/executor.dart';

dynamic _runInIsolate(args) {
  print(args);
  return 0;
}

void main() {
  runApp(MyApp());
  // do not run cachedExecutor if you want prewarm FlutterEngine!
  cachedExecutor.run(_runInIsolate, "run in isolate");
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: MyHomePage(title: 'Flutter Demo Home Page'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  MyHomePage({Key key, this.title}) : super(key: key);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          children: <Widget>[
            RaisedButton(
              onPressed: () => SystemNavigator.pop(),
              child: Text("SystemNavigator.pop()"),
            ),
             RaisedButton(
              onPressed: () {
                cachedExecutor.close();
                SystemNavigator.pop();
              },
              child: Text("SystemNavigator.pop() after isolate shudown"),
            ),
          ],
        ),
      ),
    );
  }
}
