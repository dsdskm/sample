import 'dart:async';
import 'dart:math';

import 'package:camera/camera.dart';
import 'package:flutter/material.dart';
import 'package:camera_platform_interface/camera_platform_interface.dart';
import 'package:motion_sensors/motion_sensors.dart';

/// A widget showing a live camera preview.

double _initPosX = 0;
double _initPosY = 0;
double _width = 0;
double _height = 0;
double _posX = 0;
double _posY = 0;

class MyCameraPreview extends StatelessWidget {
  CameraController _controller;

  MyCameraPreview(this._controller);

  @override
  Widget build(BuildContext context) {
    _width = MediaQuery.of(context).size.width;
    _height = MediaQuery.of(context).size.height;
    print("build _width $_width _height $_height");
    return MyHomePage(_controller, "title");
  }
}

class MyHomePage extends StatefulWidget {
  CameraController _controller;

  MyHomePage(this._controller, this.title);

  final String title;

  @override
  _MyHomePageState createState() => _MyHomePageState(_controller);
}

class _MyHomePageState extends State<MyHomePage> {
  CameraController _controller;
  bool _isVisible = false;
  int _ranBoxNumber = -1;

  _MyHomePageState(this._controller) {
    initBox();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Stack(
        children: [
          CameraPlatform.instance.buildPreview(_controller.cameraId),
          _isVisible ? getBoxWidget() : Container()
        ],
      ),
    );
  }

  @override
  void dispose() {
    super.dispose();
  }

  @override
  void initState() {
    super.initState();
    print("initState");
    motionSensors.magnetometerUpdateInterval = 10000;
    motionSensors.magnetometer.listen((MagnetometerEvent event) {
      if (_isVisible) {
        updateBoxPos(event.x, event.y);
      } else {
        checkLevel(event.x, event.y);
      }
    });
  }

  void checkLevel(double x, double y) {
    print("checkLevel _ranBoxNumber $_ranBoxNumber $x $y");
    switch (_ranBoxNumber) {
      case 0:
        if (-10 <= x && x < 25 && y < -30) {
          _isVisible = true;
        } else {
          _isVisible = false;
        }
        break;
      case 1:
        if (-10 <= x && x < 25 && -30 <= y && y < -20) {
          _isVisible = true;
        } else {
          _isVisible = false;
        }
        break;
      case 2:
        if (25 <= x && y < -30) {
          _isVisible = true;
        } else {
          _isVisible = false;
        }
        break;
      case 3:
        if (25 <= x && -30 <= y && y < -20) {
          _isVisible = true;
        } else {
          _isVisible = false;
        }
        break;
    }
    if (_isVisible) {
      setState(() {});
    }
  }

  void initBox() {
    _ranBoxNumber = Random().nextInt(4); // for find box
    int ran = Random().nextInt(4); // for set pos
    print("initBox _ranBoxNumber $_ranBoxNumber ran $ran");

    // 센터를 중심으로 마진을 준다
    // 기본 마진 값을 잡고 거기에 +- 하는 방식
    _initPosX = 10 + _width * (Random().nextDouble() - 0.5);
    _initPosY = 10 + _height * (Random().nextDouble() - 0.5);
    if (ran == 0) {
      _initPosX = _initPosX * 1;
      _initPosY = _initPosY * 1;
    } else if (ran == 1) {
      _initPosX = _initPosX * 1;
      _initPosY = _initPosY * -1;
    } else if (ran == 2) {
      _initPosX = _initPosX * -1;
      _initPosY = _initPosY * 1;
    } else if (ran == 3) {
      _initPosX = _initPosX * -1;
      _initPosY = _initPosY * -1;
    }
    print("initBox _initPosX $_initPosX _initPosY $_initPosY");
  }

  double directX = 0;
  double directY = 0;

  void updateBoxPos(double x, double y) {
    directX = x;
    directY = y;
    _posX = x * 10;
    _posY = y * 10;
    _posX = _posX < 0 ? _posX * -1 : _posX;
    _posY = _posY < 0 ? _posY * -1 : _posY;
    print("updateBoxPos x $x y $y _posX $_posX _posY $_posY");
    setState(() {});
  }

  getBoxWidget() {
    double posX = _posX;
    double posY = _posY;
    print(
        "getBoxWidget directX $directX directY $directY posX $posX posY $posY");
    EdgeInsets m;
    if (directX > 0 && directY > 0) {
      m = EdgeInsets.only(right: posX, bottom: posY);
    } else if (directX > 0 && directY < 0) {
      m = EdgeInsets.only(right: posX, top: posY);
    } else if (directX < 0 && directY > 0) {
      m = EdgeInsets.only(left: posX, bottom: posY);
    } else {
      m = EdgeInsets.only(left: posX, top: posY);
    }
    return Align(
        child: Container(
      margin: m,
      width: 150,
      height: 150,
      color: Colors.blue,
      alignment: Alignment.center,
      child: Image.network(
        "http://dsdskm.com/findgo_main/box_images/moli.png",
        fit: BoxFit.contain,
        width: 150,
        height: 150,
      ),
    ));
  }
}
