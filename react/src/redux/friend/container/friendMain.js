import React from "react";
import store from "redux/common/store";
import { getNextFriend } from "redux/common/mockData";
import { addFriend } from "redux/friend/state";
import FriendList from "redux/friend/component/friendList";
import { connect } from "react-redux";

class FriendMain extends React.Component {
  onAdd = () => {
    const friend = getNextFriend();
    this.props.addFriend(friend);
  };

  render() {
    console.log(`FriendMain render`);
    const { friends } = this.props;
    return (
      <div>
        <button onClick={this.onAdd}>친구 추가</button>
        <FriendList friends={friends} />
      </div>
    );
  }
}

const mapStateToProps = (state) => {
  return { friends: state.friend.friends };
};

const mapDispatchToProps = (dispatch) => {
  return {
    addFriend: (friend) => {
      dispatch(addFriend(friend));
    },
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(FriendMain);
