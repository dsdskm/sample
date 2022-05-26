import product from "immer";

export default function createReducer(initialState, handlerMap) {
  return function (state = initialState, action) {
    return product(state, (draft) => {
      const handler = handlerMap[action.type];
      if (handler) {
        handler(draft, action);
      }
    });
  };
}
