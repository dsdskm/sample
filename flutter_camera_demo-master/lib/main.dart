import 'package:camera/camera.dart';
import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_camera_app/constant/Constant.dart';
import 'package:flutter_camera_app/screen/CameraHomeScreen.dart';
import 'package:flutter_camera_app/screen/HomeScreen.dart';
import 'package:flutter_camera_app/screen/SplashScreen.dart';

List<CameraDescription> cameras;

Future<Null> main() async {
  WidgetsFlutterBinding.ensureInitialized();

  try {
    cameras = await availableCameras();
  } on CameraException catch (e) {
    //logError(e.code, e.description);
  }

  runApp(
    MaterialApp(
      title: "Camera App",
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: CameraHomeScreen(cameras),
      routes: <String, WidgetBuilder>{
        HOME_SCREEN: (BuildContext context) => HomeScreen(),
        CAMERA_SCREEN: (BuildContext context) => CameraHomeScreen(cameras),
      },
    ),
  );
}
