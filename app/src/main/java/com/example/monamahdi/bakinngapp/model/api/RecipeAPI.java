package com.example.monamahdi.bakinngapp.model.api;

import com.example.monamahdi.bakinngapp.model.pojo.Recipe;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecipeAPI {

    @GET("2017/May/59121517_baking/baking.json")
    Call<ArrayList<Recipe>> getAllRecipes();
}
