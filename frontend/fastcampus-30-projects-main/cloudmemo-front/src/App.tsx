import React from 'react';
import { BrowserRouter } from 'react-router-dom';
import Routes from './Routes';
import './App.css';
import axios from 'axios';
import { css, Global } from '@emotion/react';

axios.defaults.baseURL = "http://localhost:8080"

function App() {
	return (
		<>
			<Global styles={css`
			.memo-content img {
				max-width: 100%;
			}
		`} />
			<BrowserRouter>
				<Routes />
			</BrowserRouter>
		</>
	);
}

export default App;
