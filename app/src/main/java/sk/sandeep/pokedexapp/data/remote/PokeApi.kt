package sk.sandeep.pokedexapp.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import sk.sandeep.pokedexapp.data.remote.responses.Pokemon
import sk.sandeep.pokedexapp.data.remote.responses.PokemonList

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
    ): PokemonList

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonInfo(
        @Path("pokemonName") pokemonName: String
    ): Pokemon
}