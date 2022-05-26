import React from "react";
import store from "redux/common/store";
import { getNextTimeline } from "redux/common/mockData";
import { addTimeline } from "redux/timeline/state";
import TimelineList from "redux/timeline/component/timelineList";

class TimelineMain extends React.Component {
  componentDidMount() {
    this.unsubscribe = store.subscribe(() => this.forceUpdate());
  }

  componentWillUnmount() {
    this.unsubscribe();
  }

  onAdd = () => {
    const timeline = getNextTimeline();
    store.dispatch(addTimeline(timeline));
  };

  render() {
    console.log("TimelineMain render");
    const timelines = store.getState().timeline.timelines;
    return (
      <div>
        <button onClick={this.onAdd}>타임라인 추가</button>
        <TimelineList timelines={timelines} />
      </div>
    );
  }
}

export default TimelineMain