import React, { Component } from 'react';
import { Route } from 'react-router-dom';
import Home from "./Home/Home.js";
import PlacePage from "./PlacePage/index.js";
import RegistrationForm from "./RegistrationForm";
import LoginPage from "./LoginPage";
import MapForm from "./Map/MapForm";
import UserPage from "./UserPage/UserPage";
import RegisterPlace from "./RegisterPlace/RegisterPlace";
import AppInfo from "./Home/AppInfo";
import UserPlaces from "./User/UserPlaces/UserPlaces";
import {Session} from "../utils";
import AdminPage from "./Admin/AdminPage";
import ApprovablePlaces from "./ApprovePlace/ApprovablePlaces"

export default class Routes extends Component {

    render() {
        const userId = Session.userId();
        const style = {
            minHeight: this.props.minHeight
        };

        return (
            <div id="router" style={style}>
                <Route path="//" component={Home}/>
                <Route path="/app-info" component={AppInfo}/>
                <Route path="/sign-in"
                       render={(routeProps) => <LoginPage {...routeProps}
                                                          handleAvatarUpdated={this.props.handleAvatarUpdated}/>
                       }
                />
                <Route path="/sign-up" component={RegistrationForm}/>
                <Route path="/map" component={MapForm}/>
                <Route path="/place/:placeId" component={PlacePage}/>
                <Route path="/user/profile"
                       render={(routeProps) => <UserPage {...routeProps}
                                                         handleAvatarUpdated={this.props.handleAvatarUpdated}/>
                       }
                />
                <Route path={`/user/${userId}/places`} component={UserPlaces}/>
                <Route path="/register-place" component={RegisterPlace}/>
                <Route path="/admin-page" component={AdminPage}/>
            </div>
        );
    }

}