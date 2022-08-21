import React from 'react';
import styled from '@emotion/styled';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import MainPage from './pages/MainPage';
import MovieDetail from './pages/MovieDetail';
import TvPage from './pages/TvPage';
import TvDetail from './pages/TvDetail';

import LoginModal from './features/app/LoginModal';
import SignupModal from './features/app/SignupModal';

const Base = styled.div``;

function App() {
  return (
    <Base>
      <Router>
        <Switch>
          <Route exact path="/" component={MainPage} />
          <Route exact path="/tv" component={TvPage} />
          <Route exact path="/movie/:id" component={MovieDetail} />
          <Route exact path="/tv/:id" component={TvDetail} />
        </Switch>
      </Router>
      <LoginModal />
      <SignupModal />
    </Base>
  );
}

export default App;
