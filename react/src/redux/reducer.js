import React, { useReducer } from "react";
import { createStore, combineReducers } from "redux";
import timelineReducer, {
  addTimeline,
  removeTimeline,
  editTimeline,
  increaseNextPage,
} from "./timeline/state";

import friendReducer, {
  addFriend,
  removeFriend,
  editFriend,
} from "./friend/state";

import FriendMain from "redux/friend/container/friendMain";
import TimelineMain from "redux/timeline/container/timelineMain";
import { Provider } from "react-redux";
import store from "redux/common/store";

function reducer(state, action) {
  switch (action.type) {
    case "INCREMENT":
      return state + 1;
    case "DECREMENT":
      return state - 1;
    default:
      return state;
  }
}

const Reducer = () => {
  return (
    <div>
      <Provider store={store}>
        <FriendMain />
        <TimelineMain />
      </Provider>
    </div>
  );
};

export default Reducer;
