const { app, BrowserWindow } = require("electron");

const path = require("path");
// const firebase = require("firebase");
// const admin = require("firebase-admin");
// admin.initializeApp();
// const db = admin.firestore();

function createWindow() {
  const win = new BrowserWindow({
    show: false,
    webPreferences: {
      nodeIntegration: true,
    },
  });
  win.maximize();
  win.loadFile("index.html");
  //   win.loadURL("http://localhost:3000/lgsp_dev/gs25_kkh");
  win.show();
  win.webContents.openDevTools();

  //   db.collection("lgsp_dev")
  //     .doc("gs25_kkh")
  //     .get()
  //     .then((doc) => {
  //       const data = doc.data();
  //       console.log(`data ${JSON.stringify(data)}`);
  //     });
}

app.whenReady().then(() => {
  createWindow();

  app.on("activate", () => {
    if (BrowserWindow.getAllWindows().length === 0) {
      createWindow();
    }
  });
});

app.on("window-all-closed", () => {
  if (process.platform !== "darwin") {
    app.quit();
  }
});
