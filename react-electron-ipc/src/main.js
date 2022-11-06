const { app, BrowserWindow, ipcMain, Notification } = require("electron");
const path = require("path");
const { electron } = require("process");

const { SEND_MAIN_PING } = require("./constants");

const NOTIFICATION_TITLE = "Basic Notification";
const NOTIFICATION_BODY = "Notification from the Main process";
function showNotification() {
  console.log(`path ${path} __dirname ${__dirname} ${path.join(__dirname, "success.mp3")}`);
  const noti = new Notification({
    title: NOTIFICATION_TITLE,
    body: NOTIFICATION_BODY,
    silent: true,
  });
  noti.show();
  const sound = require("sound-play");
  sound.play(path.join(__dirname, "success.mp3"));
}

function createWindow() {
  const win = new BrowserWindow({
    width: 800,
    height: 600,
    webPreferences: {
      nodeIntegration: true,
      contextIsolation: false,
    },
  });
  win.loadURL("http://localhost:3000");
  win.webContents.openDevTools();
}
ipcMain.on(SEND_MAIN_PING, (event, arg) => {
  console.log("Main received a ping!!!");
  showNotification();
});
app.whenReady().then(() => {
  createWindow();
  showNotification();
});
app.on("window-all-closed", function () {
  if (process.platform !== "darwin") app.quit();
});
